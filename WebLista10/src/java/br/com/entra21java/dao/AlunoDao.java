package br.com.entra21java.dao;
import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



 /* @author Márcio Pedro Schiehl
 */
public class AlunoDao {
    public int adicionar(AlunoBean alunos){
        String sql = "INSERT INTO alunos(id,nome,nota1,nota2,nota3,"
                + "codigo_de_matricula ,frequencia)"
                + "values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, alunos.getNome());
            ps.setFloat(quantidade++, alunos.getNota1());
            ps.setFloat(quantidade++, alunos.getNota2());
            ps.setFloat(quantidade++, alunos.getNota3());
            ps.setString(quantidade++, alunos.getCodigoDeMatricula());
            ps.setByte(quantidade++, alunos.getFrequencia());
            ps.execute();
            ResultSet resultset = ps.getGeneratedKeys();
            if(resultset.next()){
                return resultset.getInt(1);
            }            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Conexao.fecharConexao();
        }
        return -1;
    }
    
    public boolean excluir(int id){
        String sql = "DELETE FROM  alunos WHERE id = ?;";
        Connection conexao = Conexao.obterConexao();
        if(conexao!=null){
            try{
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() ==1;
            }catch(SQLException e){
                e.printStackTrace();
            }finally{Conexao.fecharConexao();}
        }
        return false;
    }
    
    public boolean alterar(AlunoBean aluno){
        Connection conexao = Conexao.obterConexao();
        String sql = "UPDATE alunos"
                +"\nSet nome = ?,codigo_matricula = ?,nota_1 = ?" +
                "nota_2 = ?,nota_3 =?, frequencia = ? "+
                "WHERE id = ?;";
        if(conexao!= null){
            try{
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCodigoDeMatricula());
                ps.setFloat(3, aluno.getNota1());
                ps.setFloat(4, aluno.getNota2());
                ps.setFloat(5, aluno.getNota3());
                ps.setByte(6, aluno.getFrequencia());
                ps.setInt(7, aluno.getId());
                return ps.executeUpdate() == 1;
            }catch(SQLException e){
                e.printStackTrace();
            }finally{Conexao.fecharConexao();}
        }
        return false;
    }
}


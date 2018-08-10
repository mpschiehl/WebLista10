package br.com.entra21java.dao;
import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.database.Conexao;
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
    
}

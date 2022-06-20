import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main ( String[] args ) {

        // 接続文字列の設定
        String url = "jdbc:postgresql://localhost:5432/testdb" ;
        String user = "postgres" ;
        String password = "pass" ;

        // SELECT文の作成・実行
        String sql = "SELECT * from public.keyakizaka" ;

        // PostgreSQLに接続
        try (Connection con = DriverManager.getConnection ( url, user, password );
                Statement stmt = con.createStatement();
                ResultSet result = stmt.executeQuery ( sql ); ) {

            // 実行結果の取得
            while ( result.next() ) {
                String col1 = result.getString ( 1 ) ;
                String col2 = result.getString ( 2 ) ;
                String col3 = result.getString ( 3 ) ;
                String col4 = result.getString ( 4 ) ;
                String col5 = result.getString ( 5 ) ;
                System.out.println ( col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5) ;
            }
        } catch ( SQLException e ) {
          e.printStackTrace() ;
      }
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("フォワード先URL");
    dispatcher.forward(request, response)
}
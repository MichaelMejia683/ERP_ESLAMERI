package Servicios;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author jorgeluis
 */

public class conexionBD {
    
    public DataSource dataSource;
    
    public String url = "jdbc:postgresql://localhost:5432/ERP_ESLAMERI";
    public String user = "postgres";
    public String pass = "4gr4f*8520";
    
//  Coneccion para loguin


    public conexionBD(){

        inicializaDataSource();

    }



    private void inicializaDataSource(){


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);

        dataSource = basicDataSource;

    }

    

    
}
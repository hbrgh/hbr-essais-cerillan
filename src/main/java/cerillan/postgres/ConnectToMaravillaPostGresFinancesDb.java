package cerillan.postgres;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectToMaravillaPostGresFinancesDb {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ConnectToMaravillaPostGresFinancesDb.class);
	
    private final String url = "jdbc:postgresql://maravilla/finances";
    private final String user = "finances";
    private final String password = "zbas";
    private Connection connToFinancesDb = null;
    
    

    public ConnectToMaravillaPostGresFinancesDb() {
		super();
		connect();
	}
    
    

	public Connection getConnToFinancesDb() {
		return connToFinancesDb;
	}



	public void setConnToFinancesDb(Connection connToFinancesDb) {
		this.connToFinancesDb = connToFinancesDb;
	}



	/**
     * Connect to the PostgreSQL database
     *
     */
    public void connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
            	LOGGER.info("Connected to the PostgreSQL server successfully.");
            } else {
                LOGGER.error("Failed to make connection!");
            }

        } catch (SQLException e) {
        	LOGGER.error(e.getMessage());
        	throw new RuntimeException(e);
        }

       this.connToFinancesDb = conn;
    }
    
    public void close() {
    	try {
			this.connToFinancesDb.close();
			LOGGER.info("Connection to the PostgreSQL server closed.");
		} catch (SQLException e) {
        	LOGGER.error(e.getMessage());
        	throw new RuntimeException(e);
		}
    }

    /**
     * @param args the command line arguments
     * @throws SQLException 
     */
    public static void main(String[] args)  {
    	ConnectToMaravillaPostGresFinancesDb app = new ConnectToMaravillaPostGresFinancesDb();
    	app.close();
       
    
    }
    
}



package cerillan.postgres;




import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cerillan.utils.VariousUtils;



/**
 * Insert PrepareStatement JDBC Example
 * 
 * @author Ramesh Fadatare
 *
 */
public class InsertRecordFinancesGainsTable {
	private static Logger LOGGER = LoggerFactory.getLogger(InsertRecordFinancesGainsTable.class);
	
	public static final int NB_MIN_LAUNCH_ARGS = 4;
    
   
    
    private ConnectToMaravillaPostGresFinancesDb connToMaravillaPostGresFinancesDb = null;

  //insert into gains(motif, montant, compte, jour) values('salaire janvier', 418306, 'SBE', '2021-01-31');
    private static final String INSERT_GAINS_SQL = "INSERT INTO gains" +
        "  (motif, montant, compte, jour, annee) VALUES " +
        " (?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?);";
    
    private static final String INSERT_GAINS_SQL_WITH_ORIGIN = "INSERT INTO gains" +
            "  (motif, montant, compte, jour, annee, origine) VALUES " +
            " (?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?);";
    
    
    
    public InsertRecordFinancesGainsTable(ConnectToMaravillaPostGresFinancesDb connToMaravillaPostGresFinancesDb) {
	super();
	this.connToMaravillaPostGresFinancesDb = connToMaravillaPostGresFinancesDb;
}



	

	

    public static void main(String[] args) throws SQLException {
    	
		VariousUtils.writeLaunchedJVMdetails();
		VariousUtils.writeLaunchedApplicationArgs();
		String nameOfMainClass = VariousUtils.getMainClassName();
		VariousUtils.happyBeginning(nameOfMainClass);
		
		int nbArgs = args.length;
		
		if (nbArgs < NB_MIN_LAUNCH_ARGS) {
			LOGGER.error("Usage: " + nameOfMainClass + " <motif> <montant> <compte> <jour>");
			LOGGER.error("Example: " + nameOfMainClass + " 'salaire janvier' 418306 'SBE' '2021-01-31'");
			VariousUtils.harakiri(VariousUtils.MESS_ERR_FATALE_NB_ARGS_INCORRECT, nameOfMainClass);
		}
			
		
    	ConnectToMaravillaPostGresFinancesDb lConnectToMaravillaPostGresFinancesDb = 
    			new ConnectToMaravillaPostGresFinancesDb();
    	InsertRecordFinancesGainsTable lInsertRecordFinancesGainsTable = 
    			new InsertRecordFinancesGainsTable(lConnectToMaravillaPostGresFinancesDb);
    	lInsertRecordFinancesGainsTable.insertRecord(args);
    	
    	lConnectToMaravillaPostGresFinancesDb.close();
    	
    	VariousUtils.happyEnd(nameOfMainClass);
     
    }

    public void insertRecord(String[] args)  {
    	String jour = args[3];
    	int annee = Integer.parseInt(jour.substring(0,4));
    	String motif = args[0];
    	int montant = Integer.parseInt(args[1]);
    	String compte = args[2];
    	String orig = args[5];
     
        // Step 1: Establishing a Connection
        try (

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = 
            	this.connToMaravillaPostGresFinancesDb.getConnToFinancesDb().prepareStatement(INSERT_GAINS_SQL_WITH_ORIGIN)) {
            preparedStatement.setString(1, motif);
            preparedStatement.setInt(2, montant);
            preparedStatement.setString(3, compte);
            preparedStatement.setString(4, jour);
            preparedStatement.setInt(5, annee);
            preparedStatement.setString(6, orig);

           LOGGER.info(preparedStatement.toString());
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	this.connToMaravillaPostGresFinancesDb.close();
        	VariousUtils.harakiri(e);

        }

        
    }

//    public static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}
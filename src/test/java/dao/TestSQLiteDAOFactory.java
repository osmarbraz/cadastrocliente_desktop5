package dao;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestSQLiteDAOFactory {

    /**
     * Testa se o driver nimport static org.junit.jupiter.api.Assertions.assertNull;
ão existe.
     */
    @Test
    public void testGetConnectionDriver() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        sqlitedaofactory.setDriverClass("X");
        sqlitedaofactory.setJdbcURL("jdbc:sqlite:cliente.db");
        assertNull(sqlitedaofactory.getConnection());
    }
    
    /**
     * Testa se a url não existe.
     */
    @Test
    public void testGetConnectionURL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        sqlitedaofactory.setDriverClass("org.sqlite.JDBC");
        sqlitedaofactory.setJdbcURL("Y");
        assertNull(sqlitedaofactory.getConnection());
    }

    /**
     * Testa se o preparaSQL não existe.
     */
    @Test
    public void testPrepareSQL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        String prepara = sqlitedaofactory.preparaSQL(null);
        assertTrue(prepara.equals(""));
    }
}

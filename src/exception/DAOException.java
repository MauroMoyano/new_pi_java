package exception;

import java.sql.SQLException;

public class DAOException extends Throwable {
    public DAOException(String message) {
        super();
    }
    public DAOException(String message, SQLException exception) {
        super();
    }
}

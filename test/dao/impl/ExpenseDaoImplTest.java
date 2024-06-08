package dao.impl;


import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExpenseDaoImplTest {

    //Connection connectionMock = mock(Connection.class);

    @Mock
    private Connection connectionMock;
    @Mock
    private PreparedStatement psMock;

    private final ResultSet rsMock = mock(ResultSet.class);

    private ExpenseDao expenseDao;

    @BeforeEach
    void setUp() throws SQLException {
//        connectionMock = mock(Connection.class);
//        psMock = mock(PreparedStatement.class);
        MockitoAnnotations.initMocks(this); // reemplaza las inicializaciones individuales que hacemos arriba

        when(connectionMock.prepareStatement(anyString())).thenReturn(psMock);
        expenseDao = new ExpenseDaoImpl(connectionMock);
    }

    @Test
    @DisplayName("Cuando inserto un dto con valores correctos, el registro se inserta correctamente")
    void insert_ShouldInsertExpense_WhenValidExpenseDto() throws SQLException {
        // GIVEN
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(100.00);
        expenseDto.setCategoryId(2);
        expenseDto.setDate("2023-08-12");

        when(psMock.executeUpdate()).thenReturn(1);

        //WHEN
        expenseDao.insert(expenseDto);

        //THEN
        verify(psMock).setDouble(1, expenseDto.getAmount());
        verify(psMock).setInt(2, expenseDto.getCategoryId());
        verify(psMock).setString(3, expenseDto.getDate());
        verify(psMock, times(1)).executeUpdate();


    }

    @Test
    void getAll_ShouldReturnListOfExpenseDto_WhenDataBaseHasData() throws SQLException {
        // GIVEN
        List<ExpenseDto> expectedList;
        expectedList = List.of(
                new ExpenseDto(100.00, "2023-08-12", 2),
                new ExpenseDto(200.00, "2023-08-13", 2)
//                new ExpenseDto(300.00, "2023-08-12", 2)
        );

        when(psMock.executeQuery()).thenReturn(rsMock);
        when(rsMock.next()).thenReturn(true, true, false);
        when(rsMock.getInt("id")).thenReturn(1, 2);
        when(rsMock.getDouble("amount")).thenReturn(100.00, 200.00);
        when(rsMock.getInt("category_id")).thenReturn(2);
        when(rsMock.getString("date")).thenReturn("2023-08-12", "2023-08-13");

        // WHEN
        List<ExpenseDto> resultList = expenseDao.getAll();

        // THEN
        verify(psMock).executeQuery();
        verify(rsMock, times(2)).getInt("id");
        verify(rsMock, times(2)).getInt("category_id");
        verify(rsMock, times(2)).getDouble("amount");
        verify(rsMock, times(2)).getString("date");
        assertEquals(expectedList.size(), resultList.size());

    }

}
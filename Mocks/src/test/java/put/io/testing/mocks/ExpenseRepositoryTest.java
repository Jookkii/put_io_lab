package put.io.testing.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        InOrder inOrder = inOrder(mock);
        //given
        ExpenseRepository rep = new ExpenseRepository(mock);
        //when
        when(mock.queryAll()).thenReturn(Collections.emptyList());
        rep.loadExpenses();
        inOrder.verify(mock).connect();
        inOrder.verify(mock).queryAll();
        inOrder.verify(mock).close();

        //then
        assertArrayEquals(rep.getExpenses().toArray(), new Expense[]{});
    }

    @Test
    void saveExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        InOrder inOrder = inOrder(mock);
        //given
        ExpenseRepository rep = new ExpenseRepository(mock);
        //when
        when(mock.queryAll()).thenReturn(Collections.emptyList());
        Expense expense = new Expense();
        rep.loadExpenses();
        rep.addExpense(expense);
        for (int i = 0; i < 5; i++) {
            rep.saveExpenses();
        }
        inOrder.verify(mock).connect();
        inOrder.verify(mock).queryAll();
        inOrder.verify(mock).close();

        //then
        verify(mock, times(5)).persist(any(Expense.class));
    }
}

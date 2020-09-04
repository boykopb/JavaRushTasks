package com.javarush.task.task25.task2503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

     Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;

            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;

                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */

    public static List<Column> getVisibleColumns() {

        Column [] cl = new  Column[4];
        List<Column> result = new LinkedList<>();
        for (int i = 0; i < realOrder.length; i++)
        {
            if (realOrder[i] != - 1){
                cl[realOrder[i]] = Column.values()[i];}
        }
        for (int i = 0; i < cl.length; i++ ){
            if (cl[i] != null)
                result.add(cl[i]);
        }

        return result;
    }


    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown() {
        return realOrder[this.ordinal()] !=-1;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */

    @Override
    public void hide() {
    realOrder[this.ordinal()] = -1;

    }


}

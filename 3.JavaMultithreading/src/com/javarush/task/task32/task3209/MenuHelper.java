package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

/*
Dспомогательный класс для инициализации и настройки меню.
Cтруктура:
- Файл
- Новый
- Открыть
- Сохранить
- Сохранить как...
- Выход

- Редактировать
- Отменить
- Вернуть
- Вырезать
- Копировать
- Вставить

- Стиль
- Полужирный
- Подчеркнутый
- Курсив
- Подстрочный знак
- Надстрочный знак
- Зачеркнутый

- Выравнивание
- По левому краю
- По центру
- По правому краю

- Цвет
- Красный
- Оранжевый
- Желтый
- Зеленый
- Синий
- Голубой
- Пурпурный
- Черный

- Шрифт
- Шрифт
- SansSerif, Serif, Monospaced, Dialog, DialogInput,
- Размер шрифта
- 6, 8, 10, 12, 14, 16, 20, 24, 32, 36, 48, 72

- Помощь
- О программе
 */
public class MenuHelper {


    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }


    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem jMenuItem = new JMenuItem(action);
        parent.add(jMenuItem);
        return jMenuItem;
    }


    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem jMenuItem = addMenuItem(parent, action);
        jMenuItem.setText(text);
        parent.add(jMenuItem);
        return jMenuItem;
    }


    //инициализация меню помощи
    public static void initHelpMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора шрифта
    public static void initFontMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора цвета
    public static void initColorMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выравнивания
    public static void initAlignMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню выбора стиля текста
    public static void initStyleMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню редактирования текста
    public static void initEditMenu(View view, JMenuBar menuBar) {

    }

    //инициализация меню Файл
    public static void initFileMenu(View view, JMenuBar menuBar) {

    }
}

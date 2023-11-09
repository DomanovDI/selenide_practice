package com.herokuapp;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDrop {
    @Test
    void dragAndDropTest() {
        /*  Запрограммируйте Drag&Drop с помощью Selenide.actions()
            - Откройте https://the-internet.herokuapp.com/drag_and_drop
            - Перенесите прямоугольник А на место В
            - Проверьте, что прямоугольники действительно поменялись
            - В Selenide есть команда $(element).dragAndDrop($(to-element)),
            проверьте работает ли тест, если использовать её вместо actions() */
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        //actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(250, 0).release().perform();
        //Строчка кода для создания конфликта в Гите
    }
}

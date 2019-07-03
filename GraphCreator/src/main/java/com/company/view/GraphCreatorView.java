package com.company.view;

import java.io.File;

/**
 * Интерфейс представления
 * void setLabelHelp(String strHelp) - показать помощь пользователю
 * void showErrorDialog(String message) - показать ошибку
 * String showInputDialog(String title,String message) - показать диалог для пользователя
 * File showFileChooserDialog(String title) - открыть окно выбора файла
 */
public interface GraphCreatorView {
    void setEnabledControlStepButton(boolean show);

    void setLabelHelp(String strHelp);

    void showErrorDialog(String title, String message);

    String showInputDialog(String title, String message);

    File showFileChooserDialog(String title);

    String getSelectAlgorithm();
}

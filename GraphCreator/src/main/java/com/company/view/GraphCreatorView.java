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
    void setEnabledStartButton(boolean show);

    void setEnabledFinishButton(boolean show);

    void setEnabledNextButton(boolean show);

    void setEnabledBackButton(boolean show);

    void setEnabledResetButton(boolean show);

    void setLabelHelp(String strHelp);

    void setLog(String message);

    void showErrorDialog(String title, String message);

    String showInputDialog(String title, String message);

    File showFileChooserDialog(String title);

    String getSelectAlgorithm();
}

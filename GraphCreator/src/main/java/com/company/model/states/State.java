package com.company.model.states;

/**
 * Интерфейс состояний
 *  void nextStep() - следующий шаг алгоритма
 *  void backStep() - предыдущий шаг алгоритма
 *  void mousePressed(double posX, double posY, Object cell) - реакция на нажатие кнопки мыши
 *  void mouseReleased(double posX, double posY, Object cell) - реакция на отпускание кнопки мыши
 *  String getStatus() - Возвращает текущие состояние данного стейта
 *  void close() - устанавливает исходное состояние
 */
public interface State {
    void nextStep();

    void backStep();

    void startAlgorithm();

    void finishAlgorithm();

    void mousePressed(double posX, double posY, Object cell);

    void mouseReleased(double posX, double posY, Object cell);

    String getStatus();

    void close();
}


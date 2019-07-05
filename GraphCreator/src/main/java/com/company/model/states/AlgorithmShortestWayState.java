package com.company.model.states;

import com.company.model.GraphCreatorModel;
import com.company.model.adapter.GraphAdapter;
import com.company.model.algorithms.MementoShortestWayView;
import com.company.view.GraphCreatorView;
import com.mxgraph.model.mxCell;

import java.util.List;
import static com.company.Constants.StyleGraph.*;

public class AlgorithmShortestWayState implements State {

    private final GraphCreatorModel model;
    private final GraphCreatorView view;
    private final GraphAdapter adapter;
    private List<MementoShortestWayView> stepsView;
    private Status curStatus = Status.NORMAL;
    private mxCell sourceVertex = null;
    private int indexStep = -1;

    public AlgorithmShortestWayState(GraphCreatorModel model, GraphCreatorView view, GraphAdapter adapter) {
        this.model = model;
        this.view = view;
        this.adapter = adapter;
    }

    //Обработка нажатия кнопки мыши, если не выбрана не одна вершина
    private void handlerNormal(mxCell source) {
        curStatus = Status.SELECT_ONE_VERTEX;
        sourceVertex = source;
        model.setStyleSelected(true, new Object[]{sourceVertex});
    }

    //Обработка нажатия кнопки мыши, если выбрана одна вершина
    private void handlerSelectOneVer(mxCell target) {
        curStatus = Status.PROCESSING;
        model.setStyleSelected(false, new Object[]{sourceVertex});
        adapter.shortestWay(view.getSelectAlgorithm(), model.getGraph(), sourceVertex, target,
                mementosView -> {
                    stepsView = mementosView;
                    curStatus = Status.DISPLAY;
                    view.setEnabledStartButton(true);
                });
    }

    //Обработка нажатия кнопки мыши, если путь уже показан
    private void handlerDisplay(mxCell cell) {
        close();
        model.setStyleSelected(true, new Object[]{cell});
        curStatus = Status.SELECT_ONE_VERTEX;
        sourceVertex = cell;
        indexStep = -1;
    }

    //Показать шаг алгоритма
    private void showMemento(MementoShortestWayView viewMemento) {
        model.setNormalStyle();
        Object currentVertex = viewMemento.getCurrentVertex();
        Object[] processedVertices = viewMemento.getProcessedVertices();
        Object[] currentWays = viewMemento.getCurrentWays();
        Object[] inQueueVertices = viewMemento.getInQueueVertices();
        Object[] answer = viewMemento.getAnswer();
        if (currentWays != null)
            model.setStyleSelected(true, currentWays);
        if (inQueueVertices != null)
            model.setStyle(MY_CUSTOM_IN_QUEUE_VERTEX_STYLE, inQueueVertices);
        if (currentVertex != null)
            model.setStyle(MY_CUSTOM_CURRENT_VERTEX_STYLE, new Object[]{currentVertex});
        if (processedVertices != null)
            model.setStyle(MY_CUSTOM_VERTEX_SELECTED_STYLE, processedVertices);
        if (answer != null)
            model.setStyleSelected(true, answer);
        view.setLog(viewMemento.getLog());
    }

    @Override
    public void nextStep() {
        if (indexStep != -1 && (indexStep + 1) < stepsView.size() - 1) {
            showMemento(stepsView.get(++indexStep));
            view.setEnabledBackButton(true);
        }
        if (indexStep == stepsView.size() - 2)
            view.setEnabledNextButton(false);
    }

    @Override
    public void backStep() {
        if (indexStep != -1 && (indexStep - 1 >= 0)) {
            showMemento(stepsView.get(--indexStep));
            view.setEnabledNextButton(true);
        }
        if (indexStep == 0)
            view.setEnabledBackButton(false);
    }

    @Override
    public void startAlgorithm() {
        view.setEnabledStartButton(false);
        view.setEnabledFinishButton(true);
        view.setEnabledNextButton(true);
        view.setEnabledBackButton(true);
        indexStep = 0;
        showMemento(stepsView.get(indexStep));
    }

    @Override
    public void finishAlgorithm() {
        view.setEnabledStartButton(false);
        view.setEnabledFinishButton(false);
        view.setEnabledNextButton(false);
        view.setEnabledBackButton(false);
        indexStep = stepsView.size() - 1;
        showMemento(stepsView.get(indexStep));
    }

    @Override
    public void mousePressed(double posX, double posY, Object cell) {
        if (cell != null && ((mxCell) cell).isVertex()) {
            mxCell clickCell = (mxCell) cell;
            if (curStatus == Status.NORMAL)
                handlerNormal(clickCell);
            else if (curStatus == Status.SELECT_ONE_VERTEX)
                handlerSelectOneVer(clickCell);
            else if (curStatus == Status.DISPLAY)
                handlerDisplay(clickCell);
        } else if (curStatus == Status.SELECT_ONE_VERTEX) {
            model.setStyleSelected(false, new Object[]{sourceVertex});
            curStatus = Status.NORMAL;
            sourceVertex = null;
        } else if (curStatus == Status.DISPLAY) {
            close();
            curStatus = Status.NORMAL;
            sourceVertex = null;
            indexStep = -1;
        }

    }

    @Override
    public void mouseReleased(double posX, double posY, Object cell) {
    }

    @Override
    public String getStatus() {
        switch (curStatus) {
            case NORMAL:
                return "Выделите вершину, из которой хотите найти кратчайших путь";
            case SELECT_ONE_VERTEX:
                return "Выделите конечную вершину кратчайшего пути";
            case PROCESSING:
                return "Обработка...";
            case DISPLAY:
                if (indexStep == -1) {
                    return "Нажмите старт,чтобы начать пошаговый просмотр алгоритма";
                } else if (indexStep == stepsView.size() - 1) {
                    return stepsView.get(stepsView.size() - 1).getLog().split("\\n")[0];
                } else {
                    return "Пошаговый режим включен";
                }
        }
        return null;
    }

    @Override
    public void close() {
        model.setNormalStyle();
        view.setEnabledStartButton(false);
        view.setEnabledFinishButton(false);
        view.setEnabledBackButton(false);
        view.setEnabledNextButton(false);
    }

    private enum Status {
        NORMAL, SELECT_ONE_VERTEX, PROCESSING, DISPLAY
    }
}

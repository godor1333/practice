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
                    view.setEnabledControlStepButton(true);
                    showMemento(mementosView.get(++indexStep));
                });
    }

    //Обработка нажатия кнопки мыши, если путь уже показан
    private void handlerDisplay(mxCell cell) {
        model.setNormalStyle();
        model.setStyleSelected(true, new Object[]{cell});
        view.setEnabledControlStepButton(false);
        curStatus = Status.SELECT_ONE_VERTEX;
        sourceVertex = cell;
        indexStep = -1;
    }

    //Показать шаг алгоритма
    private void showMemento(MementoShortestWayView view) {
        model.setNormalStyle();
        Object currentVertex = view.getCurrentVertex();
        Object[] processedVertices = view.getProcessedVertices();
        Object[] currentWays = view.getCurrentWays();
        Object[] inQueueVertices = view.getInQueueVertices();
        Object[] answer = view.getAnswer();
        if (currentWays != null)
            model.setStyleSelected(true, currentWays);
        if (inQueueVertices != null)
            model.setStyle(MY_CUSTOM_IN_QUEUE_VERTEX_STYLE, inQueueVertices);
        if (currentVertex != null)
            model.setStyle(MY_CUSTOM_CURRENT_VERTEX_STYLE, new Object[]{currentVertex});
        if (processedVertices != null)
            model.setStyle(MY_CUSTOM_VERTEX_SELECTED_STYLE, processedVertices);
        if (answer!=null)
            model.setStyleSelected(true,answer);
    }

    @Override
    public void nextStep() {
        if ((indexStep + 1) < stepsView.size()) {
            showMemento(stepsView.get(++indexStep));
        }
    }

    @Override
    public void backStep() {
        if ((indexStep - 1 >= 0)) {
            showMemento(stepsView.get(--indexStep));
        }
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
            model.setNormalStyle();
            view.setEnabledControlStepButton(false);
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
                return stepsView.get(stepsView.size() - 1).getAnswer() == null ? "Пути нет" : "Кратчайший путь найден";
        }
        return null;
    }

    @Override
    public void close() {
        model.setNormalStyle();
    }

    private enum Status {
        NORMAL, SELECT_ONE_VERTEX, PROCESSING, DISPLAY
    }
}

package com.company.view;
import com.company.controller.GraphCreatorController;
import com.company.model.GraphCreatorModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;

import java.awt.event.*;


class Creator extends mxGraphComponent {

    private static final Double MIN_SCALE = 0.5;
    private static final Double MAX_SCALE = 1.0;
    private static final Double EPS = 0.000001;
    private static final Double ZOOM_FACTORY = 1.05;

    private final GraphCreatorController controller;

    public Creator(GraphCreatorController controller, GraphCreatorModel model) {
        super((mxGraph) model.getGraph());
        this.controller = controller;
        initGUI();
        setFocusable(true);
    }

    private void initGUI() {
        setConnectable(false);
        setCenterZoom(true);
        setZoomFactor(ZOOM_FACTORY);
        addMouseWheelListener(e -> {
            double scaled = getGraph().getView().getScale();
            if (e.getWheelRotation() > 0 && scaled - MAX_SCALE < EPS) {
                zoomIn();
            } else if (e.getWheelRotation() < 0 && scaled - MIN_SCALE > EPS) {
                zoomOut();
            }
        });

        getGraphControl().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                controller.mousePressed(e, getCellAt(e.getX(), e.getY()));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                controller.mouseReleased(e, getCellAt(e.getX(), e.getY()));
            }

        });
        getGraph().addListener(mxEvent.MOVE_CELLS, (o, mxEventObject) -> controller.mouseReleased(null, null));
    }
}

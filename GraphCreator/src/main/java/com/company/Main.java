package com.company;

import com.company.controller.GraphCreatorControllerImpl;
import com.company.model.GraphCreatorModel;
import com.company.model.GraphCreatorModelImpl;
import com.company.model.adapter.MxGraphAdapter;
import com.company.view.GraphCreatorViewImpl;

public class Main {

    public static void main(String[] args) {
        GraphCreatorModel graphCreatorModel = new GraphCreatorModelImpl();
        GraphCreatorControllerImpl graphCreatorController = new GraphCreatorControllerImpl(graphCreatorModel,new MxGraphAdapter());
        new GraphCreatorViewImpl(graphCreatorController, graphCreatorModel);
    }
}

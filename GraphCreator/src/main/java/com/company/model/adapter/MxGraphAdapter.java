package com.company.model.adapter;


import com.company.model.algorithms.MementoShortestWayView;
import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import java.util.*;
import java.util.function.Consumer;

import static com.company.Constants.SEPARATOR;
import static com.company.Constants.Algorithms.*;

public class MxGraphAdapter implements GraphAdapter {



    @Override
    public void shortestWay(String alg, Object gr, Object s, Object t, Consumer<List<MementoShortestWayView>> callbackEnd) {

    }
}

package com.company.model.adapter;
import com.company.model.algorithms.MementoShortestWayView;
import com.mxgraph.view.mxGraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface GraphAdapter {
    void shortestWay(String alg, Object gr, Object s, Object t, Consumer<List<MementoShortestWayView>> callbackEnd);
}

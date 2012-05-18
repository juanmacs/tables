/*
 * Copyright (C) 2012 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.opendatakit.tables.Activity.graphs;

import java.util.ArrayList;
import java.util.List;

import org.opendatakit.tables.Library.graphs.GValueYPoint;
import org.opendatakit.tables.Library.graphs.GraphFactory;

import android.os.Bundle;


public class LineActivity extends GraphActivity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get x and y values
        ArrayList<String> x = getIntent().getExtras().getStringArrayList("x");
        double[] y = getIntent().getExtras().getDoubleArray("y");
        String xname = getIntent().getExtras().getString("xname");
        String yname = getIntent().getExtras().getString("yname");
        
        // Check if data is valid to graph
        if ( (x != null && y != null) 
        		&& (x.size() == y.length) ) {
                
	        // Convert
	        List<GValueYPoint> list = createPlotData(x, y);
	    	
	        // Draw Line Graph
	        GraphFactory f = new GraphFactory(this);
	    	setContentView(f.getValueYLineGraph(list, "", xname, yname));
        } 
    }
    
    private List<GValueYPoint> createPlotData(ArrayList<String> x, double[] y) {
		// Result
    	List<GValueYPoint> list = new ArrayList<GValueYPoint>();
    	
    	// Map x and y and make a plot list
		for (int i = 0; i < x.size(); i++) {
			list.add(new GValueYPoint(x.get(i), y[i]));
		}
		    	
		return list;
    }

}
/*
 * GridViewer.java
 *
 * Copyright (C) 2009-16 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

package org.rstudio.core.client.widget;

import org.rstudio.core.client.dom.WindowEx;

import com.google.gwt.core.client.JavaScriptObject;

public class GridViewerFrame extends RStudioFrame
{
   public GridViewerFrame()
   {
      super("grid_resource/gridviewer.html?data_source=data");
   }
   
   public void onAttach()
   {
      super.onAttach();
   }
   
   public void setData(JavaScriptObject data)
   {
      WindowEx gridViewerFrameWindow = getIFrame().getContentWindow();
      setDataNative(gridViewerFrameWindow, data);
   }
   
   public void setOption(String option, String value)
   {
      WindowEx gridViewerFrameWindow = getIFrame().getContentWindow();
      setOptionNative(gridViewerFrameWindow, option, value);
   }
   
   public void setColumnDefinitionsUIVisible(boolean value, Operation onColumnDefsChange)
   {
      WindowEx gridViewerFrameWindow = getIFrame().getContentWindow();
      setColumnDefinitionsUIVisibleNative(gridViewerFrameWindow, value, onColumnDefsChange);
   }
   
   public JavaScriptObject getColumnDefinitions()
   {
      WindowEx gridViewerFrameWindow = getIFrame().getContentWindow();
      return getColumnDefinitions(gridViewerFrameWindow);
   }
   
   private final native void setDataNative(WindowEx frameContentWindow, JavaScriptObject data) /*-{
      frameContentWindow.setData(data);
   }-*/;
   
   private final native void setOptionNative(WindowEx frameContentWindow, String option, String value) /*-{
      frameContentWindow.setOption(option, value);
   }-*/;
   
   private final native void setColumnDefinitionsUIVisibleNative(WindowEx frameContentWindow, boolean value, Operation onColumnDefsChange) /*-{
      frameContentWindow.setColumnDefinitionsUIVisible(
         value,
         $entry(function () {
            onColumnDefsChange.@org.rstudio.core.client.widget.Operation::execute()()
         })
      );
   }-*/;
   
   private final native JavaScriptObject getColumnDefinitions(WindowEx frameContentWindow) /*-{
      return frameContentWindow.getColumnDefinitions();
   }-*/;
}

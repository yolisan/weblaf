/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.tree;

import com.alee.api.annotations.NotNull;
import com.alee.managers.style.AbstractComponentDescriptor;
import com.alee.managers.style.StyleId;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * Abstract descriptor for {@link JTree} component.
 * Extend this class for creating custom {@link JTree} descriptors.
 *
 * @param <C> {@link JComponent} type
 * @param <U> base {@link ComponentUI} type
 * @author Mikle Garin
 * @see <a href="https://github.com/mgarin/weblaf/wiki/How-to-use-StyleManager">How to use StyleManager</a>
 * @see com.alee.managers.style.StyleManager
 * @see com.alee.managers.style.StyleManager#registerComponentDescriptor(com.alee.managers.style.ComponentDescriptor)
 * @see com.alee.managers.style.StyleManager#unregisterComponentDescriptor(com.alee.managers.style.ComponentDescriptor)
 */
public abstract class AbstractTreeDescriptor<C extends JTree, U extends WTreeUI> extends AbstractComponentDescriptor<C, U>
{
    /**
     * Constructs new {@link AbstractTreeDescriptor}.
     *
     * @param id             component identifier
     * @param componentClass component class
     * @param uiClassId      component UI class ID
     * @param baseUIClass    base UI class applicable to this component
     * @param uiClass        UI class applied to the component by default
     * @param defaultStyleId component default style ID
     */
    public AbstractTreeDescriptor ( final String id, final Class<C> componentClass, final String uiClassId,
                                    final Class<U> baseUIClass, final Class<? extends U> uiClass, final StyleId defaultStyleId )
    {
        super ( id, componentClass, uiClassId, baseUIClass, uiClass, defaultStyleId );
    }

    @Override
    public void updateUI ( @NotNull final C component )
    {
        // Updating component UI
        super.updateUI ( component );

        // Updating renderer UI
        final TreeCellRenderer renderer = component.getCellRenderer ();
        if ( renderer instanceof Component )
        {
            SwingUtilities.updateComponentTreeUI ( ( Component ) renderer );
        }

        // Updating editor UI
        final TreeCellEditor editor = component.getCellEditor ();
        if ( editor instanceof Component )
        {
            SwingUtilities.updateComponentTreeUI ( ( Component ) editor );
        }
        else if ( editor instanceof DefaultCellEditor )
        {
            final Component editorComponent = ( ( DefaultCellEditor ) editor ).getComponent ();
            if ( editorComponent != null )
            {
                SwingUtilities.updateComponentTreeUI ( editorComponent );
            }
        }
    }
}
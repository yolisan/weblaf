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

package com.alee.extended.breadcrumb.element;

import com.alee.extended.breadcrumb.WebBreadcrumb;
import com.alee.laf.checkbox.CheckBoxPainter;
import com.alee.laf.checkbox.WCheckBoxUI;
import com.alee.painter.decoration.IDecoration;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.swing.*;
import java.util.List;

/**
 * {@link CheckBoxPainter} customized for usage as a {@link WebBreadcrumb} element painter.
 *
 * @param <C> component type
 * @param <U> component UI type
 * @param <D> decoration type
 * @author Mikle Garin
 */
@XStreamAlias ( "BreadcrumbCheckBoxPainter" )
public class BreadcrumbCheckBoxPainter<C extends JCheckBox, U extends WCheckBoxUI<C>, D extends IDecoration<C, D>>
        extends CheckBoxPainter<C, U, D> implements BreadcrumbElementPainter<C, U>
{
    @Override
    public List<String> getDecorationStates ()
    {
        final List<String> states = super.getDecorationStates ();

        // Adding breadcrumb element states
        BreadcrumbElementUtils.addBreadcrumbElementStates ( component, states );

        return states;
    }
}
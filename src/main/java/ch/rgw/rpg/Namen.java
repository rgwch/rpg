/*******************************************************************************
 * Copyright (c) 2010-2016, G. Weirich
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p>
 * Contributors:
 * G. Weirich - initial implementation
 * G. Weirich - extract to randomizer
 *******************************************************************************/
package ch.rgw.rpg;

import java.util.List;

public class Namen {

    List<String> vornamen;
    List<String> nachnamen;

    public Namen() {
	vornamen=FileReader.load("./vornamen.txt");
        nachnamen = FileReader.load("nachnamen.txt");
    }

    public String getRandomVorname() {
        return vornamen.get((int) Math.round(Math.random() * (vornamen.size() - 1))).trim();
    }

    public String getRandomNachname() {
        return nachnamen.get((int) Math.round(Math.random() * (nachnamen.size() - 1))).trim();
    }


}

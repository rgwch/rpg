/*******************************************************************************
 * Copyright (c) 2010-2016, G. Weirich
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    G. Weirich - initial implementation
 *    G. Weirich - extract to randomizer
 *    
 *
 *    
 *******************************************************************************/
package ch.rgw.rpg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lipsum {
	List<String> sentences;

	public Lipsum() {
		InputStream lipsum = ClassLoader.getSystemClassLoader().getResourceAsStream("lipsum.txt");
		InputStreamReader ir = new InputStreamReader(lipsum);
		BufferedReader br = new BufferedReader(ir);
		sentences = new LinkedList<String>();
		Scanner scanner = new Scanner(br);
		scanner.useDelimiter("\\.");
		while (scanner.hasNext()) {
			String s = scanner.next();
			sentences.add(s.trim());
		}
	}

	public String getSentence() {
		return sentences.get((int) Math.round(Math.random() * (sentences.size() - 1)));
	}

	public String getParagraph() {
		int num = (int) (1 + Math.round(5 * Math.random()));
		StringBuilder sb = new StringBuilder();
		while (num-- > 0) {
			sb.append(getSentence()).append(". ");
		}
		sb.append("\n\n");
		return sb.toString();
	}
}

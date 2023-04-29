package org.surus.lang.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualityTextAI {
	//formula ((text.length()+same_chars.size())*100)/(text_to_compare.length()+not_same_chars.size())
	public String text = " ";
	public String text_to_compare = text;
	public int percent_of_confidence = 100;
	public List<Character> same_chars = new ArrayList<>();
	public List<Character> not_same_chars = new ArrayList<>();
	public ArrayList<Integer> history_of_percent_of_confidence = new ArrayList<>();
	private String toString = "";

	public EqualityTextAI(String text, String text_to_compare) {
		this.text = text;
		this.text_to_compare = text_to_compare;
		init();
	}

	private void init() {
		same_chars.clear();
		not_same_chars.clear();
		if (text == null) {
			if (text_to_compare == null) {
				percent_of_confidence = 100;
			} else {
				for (int i = 0; i < text_to_compare.length(); i++) {
					not_same_chars.add(text_to_compare.charAt(i));
				}
				percent_of_confidence = 0;
			}
		} else {
			int larger = text.length();
			int smaller = text_to_compare.length();
			int array = 0;
			if (text.length() > text_to_compare.length()) {
				larger = text.length();
				smaller = text_to_compare.length();
				array = 1;
			} else {
				if (text_to_compare.length() > text.length()) {
					larger = text_to_compare.length();
					smaller = text.length();
					array = 0;
				} else {
					larger = text.length();
					smaller = text_to_compare.length();
					array = 1;
				}
			}
			for (int i = 0; i < larger; i++) {
				if (i >= smaller) {
					if (array == 1) {
						not_same_chars.add(text.charAt(i));
					} else {
						not_same_chars.add(text_to_compare.charAt(i));
					}
				} else {
					char t = text.charAt(i);
					char tc = text_to_compare.charAt(i);
					if (t == tc) {
						same_chars.add(tc);
					} else {
						not_same_chars.add(tc);
					}
				}
			}
			percent_of_confidence = same_chars.size() <= 0 ? 0 : (same_chars.size() * 100) / larger;
			history_of_percent_of_confidence.add(percent_of_confidence);
			toString += "\nPercent of confidence: " + String.valueOf(percent_of_confidence) + "%";
		}
	}

	public EqualityTextAI refresh(String text, String text_to_compare) {
		this.text = text;
		this.text_to_compare = text_to_compare;
		init();
		return this;
	}

	@Override
	public String toString() {
		return toString.replaceFirst("\n", "");
	}

}
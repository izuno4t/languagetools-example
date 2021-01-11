package com.example;

import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;

public class LanguageToolExample {

	public static void main(String[] args) throws IOException {
	    JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
	    // comment in to use statistical ngram data:
	    //langTool.activateLanguageModelRules(new File("/data/google-ngram-data"));
	    List<RuleMatch> matches = langTool.check("shop_calender userList userAggrigationList A sentence with a error in the Hitchhiker's Guide tot he Galaxy");
	    for (RuleMatch match : matches) {
	      System.out.println("Potential error at characters " +
	          match.getFromPos() + "-" + match.getToPos() + ": " +
	          match.getMessage());
	      System.out.println("Suggested correction(s): " +
	          match.getSuggestedReplacements());
	    }
	}

}

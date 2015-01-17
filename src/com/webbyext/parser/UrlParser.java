package com.webbyext.parser;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.text.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlParser {

	private String websiteTitle;
	private String url;
	private String twitter;
	private String facebook;
	private String googlePlus;
	private String behance;
	private String github;
	private String mail;
	
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebsiteTitle() {
		return websiteTitle;
	}

	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGooglePlus() {
		return googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	public String getBehance() {
		return behance;
	}

	public void setBehance(String behance) {
		this.behance = behance;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public void parseLink() throws IOException {

		// Initializing URL
		Document doc = Jsoup.connect(getUrl()).get();
		setWebsiteTitle(doc.title());
		System.out.println(getWebsiteTitle());

		// Parsing <a href> tags
		Elements link = doc.select("a[href]");
		System.out.println("Found: " + link.size() + " links!");

		// Check all links
		for (Element links : link) {

			if (links.attr("href").contains("twitter")) {
				setTwitter(links.attr("href"));
			}

			else if (links.attr("href").contains("behance")) {
				setBehance(links.attr("href"));
			}

			else if (links.attr("href").contains("facebook.com")) {
				setFacebook(links.attr("href"));
			}

			else if (links.attr("href").contains("github")) {
				setGithub(links.attr("href"));
			}

			else if (links.attr("href").contains("plus.google")) {
				setGooglePlus(links.attr("href"));
			}
			
			else if (links.attr("href").contains("mailto")) {
				setMail(links.attr("href").replace("mailto:", ""));
			}

		}

		// Debugging purposes
		if (getTwitter() != null) {
			System.out.println(getTwitter());
		}
		if (getFacebook() != null) {
			System.out.println(getFacebook());
		}
		if (getBehance() != null) {
			System.out.println(getBehance());
		}
		if (getGooglePlus() != null) {
			System.out.println(getGooglePlus());
		}
		if (getGithub() != null) {
			System.out.println(getGithub());
		}
		if (getMail() != null) {
			System.out.println(getMail());
		}

	}

}

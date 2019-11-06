/*
* Student Name: Holland Whitley
* Program Name: HTML Parser
* Creation Date: October 23, 2019
* Last Modification Date: October 28, 2019
* CSCI Course: CSCI 315
* Grade Received: 80
* Comments Regarding Design: Developed in C++ on Vim
* 	Run through command line with a makefile
*/

#include "html-parser.hpp"
#include <fstream>
#include <string>
#include <vector>
#include <iostream>

//allocation
HTMLParser::HTMLParser() {
	mStart = 0;
	mEnd = 0;
	mLink = 0;
	mEndLink = 0;
	mPos = 0;
	mPosLink = 0;
	mTempLink = 0;
	mCount = 0;
}

//deallocation
HTMLParser::~HTMLParser() {
	start.clear();
	end.clear();
	link.clear();
	endLink.clear();
	startV.clear();
	endV.clear();
	linkV.clear();
	endLinkV.clear();
	name.clear();
	isB.clear();
}

//reads in a file by character, omitting unnecessary characters
void HTMLParser::parse(std::string filename) {
	std::ifstream input(filename);
	char strChar;
	name.push_back(filename);
	while(input.get(strChar)) {
		std::string istring;
		//only does these functions if the character equals <
		if(strChar == '<') {
			if(input.peek() == 'a') {
				while(strChar != '=') {
					input.get(strChar);
				}
				//inputs any start anchor tags into link vector
				input.get(strChar);	
				while(strChar != '>') {
					istring += strChar;
					input.get(strChar);
				}
				link.push_back(istring);
				//checks for end anchor tags
				std::string linkStr;
				while (strChar != '<') {
					input.get(strChar);
				}
				if(input.peek() == '/') {
					input.get(strChar);
					if(input.peek() == 'a') {
						while(strChar != '>') {
							linkStr += strChar;
							input.get(strChar);
						}
				//counts how many end anchor tags in a file only if
				//it comes directly after the start anchor tag
						endLink.push_back(linkStr);
						mEndLink++;
					}
					else {
						while(strChar != '>') {
							input.get(strChar);
							linkStr += strChar;
						}
						end.push_back(linkStr);
				//counts how many end tags in a specific file
						mEnd++;

					}
				}
				//counts how many links are in a specific
				//file
				mLink++;
			}
			else if(input.peek() == '/') {
				//inputs starting tags in start vector
				input.get(strChar);
				if(input.peek() == 'a') {
					while(strChar != '>') {
						input.get(strChar);
					}
				}
				else {
					while(strChar != '>') {
						input.get(strChar);
						istring += strChar;
					}
					end.push_back(istring);
					//counts how many start tags in a specific
					//file
					mEnd++;
				}
			}
			else {
				//inputs end tags in end vector
				while(strChar != '>') {
					input.get(strChar);
					istring += strChar;
				}
				start.push_back(istring);
				//counts how many start tags are in file
				mStart++;
			}
		}
	}

	startV.push_back(mStart);
	endV.push_back(mEnd);
	linkV.push_back(mLink);
	endLinkV.push_back(mEndLink);
	isB.push_back(isBalanced(filename));

	input.close();
}

//checks if an html file is balanced
bool HTMLParser::isBalanced(std::string filename) {
	int i = 0;
	int k = 1;
	std::vector<std::string> newStart;
	std::vector<std::string> newEnd;

	//Matches up filename to section of vector
	for (i; i < name.size(); i++) {
		if(name.at(i) == filename) {
			mPos = i;
		}
	}

	//copies tags based on the file
	if(mPos == 0) {
		for(int j = 0; j < startV.at(mPos); j++) {
			newStart.push_back(start.at(j));
		}
		for(int j = 0; j < endV.at(mPos); j++) {
			newEnd.push_back(end.at(j));
		}
	}
	else {
		for(int j = startV.at(mPos - 1); j < startV.at(mPos); j++) {
			newStart.push_back(start.at(j));
		}
		for(int j = endV.at(mPos - 1); j < endV.at(mPos); j++) {
			newEnd.push_back(end.at(j));
		}
	}

	//Compares value of start and end vector depending on which file
	if(newStart.size() != newEnd.size()) {
		return false;
	}
	else {
		for(int j = 0; j < newStart.size(); j++) {
			if(newStart.at(j) != newEnd.at(newEnd.size() - k)) {
					return false;
			}
			k++;
		}
	}

	//Checks if the link tag has an end tag	
	if(mPos == 0) {
		if(linkV.at(mPos) != endLinkV.at(mPos)) {
			return false;
		}
	}
	else {
		int linkVNum = linkV.at(mPos) - linkV.at(mPos-1);
		int endLinkVNum = endLinkV.at(mPos) - endLinkV.at(mPos-1);
		if(linkVNum != endLinkVNum) {
			return false;
		}
	}

	return true;
}

//Calls pageCount
int HTMLParser::pageVisitAmount(std::string filename) {
	//resets values
	mCount = 0;
	visited.clear();
	return pageCount(filename);
}

//Counts how many links can be found starting at one page
int HTMLParser::pageCount(std::string filename) {
	bool linkExists = false;
	bool currentExists = false;
	int i = 0;
	
	//searches for passed in file in the existing list of filenames
	for (i; i < name.size(); i++) {
		if(name.at(i) == filename) {
			mPosLink = i;
			currentExists = true;
		}
	}

	//checks if the passed in file exists
	if(currentExists == false) {
		return mCount;
	}

	//checks if the passed in file has already been visited
	for(int k = 0; k < visited.size(); k++) {
		if(visited.at(k) == filename) {
			return mCount;
		}
	}

	//marks the current file as visited
	visited.push_back(filename);

	int startPos;
	int size = 0;

	//checks if the current file is balanced
	if(isB.at(mPosLink) == false) {
		return mCount;
	}

	//finds the number of links associated within a file
	if(mPosLink == 0) {
		size = linkV.at(mPosLink);
		if(size != 0) {
			startPos = 0;
			for(int k = startPos; k < (startPos + size); k++) {
				//checks if the associated file exists
				for(int j = 0; j < name.size(); j++) {
					if(link.at(k) == name.at(j)) {
						linkExists = true;
					}
				}
				if(linkExists == true) {
					//counts amount of pages in a link
					mCount += 1;
					pageCount(link.at(k));
				}
				linkExists = false;
			}	
		}
	}
	else {
		size = (linkV.at(mPosLink) - linkV.at(mPosLink - 1));
		if(size != 0) {
			startPos = linkV.at(mPosLink) - size;
			for(int k = startPos; k < (startPos + size); k++) {
				//checks if the associated file exists
				for(int j = 0; j < name.size(); j++) {
					if(link.at(k) == name.at(j)) {
						linkExists = true;
					}
				}
				if(linkExists == true) {
					//counts amount of pages in a link
					mCount += 1;
					pageCount(link.at(k));
				}
				linkExists = false;
			}
		}
	}

	return mCount;
}


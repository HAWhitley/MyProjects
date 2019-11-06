/*
* Student Name: Holland Whitley
* Program Name: HTML Parser
* Creation Date: October 23, 2019
* Last Modification Date: October 26, 2019
* CSCI Course: CSCI 315
* Grade Received: 80
* Comments Regarding Design: Developed in C++ on Vim
* 	Run through command line with a makefile
*/

#ifndef HTML_PARSER_HPP
#define HTML_PARSER_HPP

#include <string>
#include <fstream>
#include <vector>


class HTMLParser {
    public:
        HTMLParser();
        ~HTMLParser();

	//parses through files by character
        void parse(std::string filename);

	//checks if an html file is balanced
        bool isBalanced(std::string filename);

	//finds as number of valid links that can be visited from one page
        int pageVisitAmount(std::string filename);
	
	//recursion function for pageVisitAmount
	int pageCount(std::string filename);
    private:
	//start tags
	std::vector<std::string> start;

	//end tags
	std::vector<std::string> end;

	//links
	std::vector<std::string> link;
	std::vector<std::string> endLink;

	//number of start tags per file
	std::vector<int> startV;

	//number of end tags per file
	std::vector<int> endV;

	//number of links per file
	std::vector<int> linkV;
	std::vector<int> endLinkV;

	//marks if a file was visited
	std::vector<std::string> visited;

	//known files
	std::vector<std::string> name;

	//marks if a file is balanced
	std::vector<bool> isB;

	int mStart;
	int mEnd;
	int mLink;
	int mEndLink;
	int mPos;
	int mPosLink;
	int mTempLink;
	int mCount;
};

#endif

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

#include <iostream>
#include <sstream>
#include "html-parser.hpp"

/* Used to trim whitespace around a string.
 */
std::string trim(std::string const& str) {
    std::string word;
    std::stringstream stream(str);
    stream >> word;

    return word;
}

int main(int argc, char *argv[]) {
    // Get the program name;
    std::string programName = trim(argv[0]);
    HTMLParser htmlParser;

    // First we parse each page
    for (int i = 1; i < argc; i++) {
        // get each argument to the program.
        std::string htmlpage = argv[i];

        // If the argument is not the program
        size_t pos = htmlpage.find(programName);
        if (pos == std::string::npos) {
            // then ask to parse the HTML page.
            std::cout << "Parsing: '" << htmlpage << "'\n";
            htmlParser.parse(htmlpage);
        }
    }

    //htmlParser.print();

    // Second we print the results
    for (int i = 1; i < argc; i++) {
        // get each argument to the program.
        std::string htmlpage = argv[i];

        // If the argument is not the program
        size_t pos = htmlpage.find(programName);
        if (pos == std::string::npos) {
            /* then print out if it is balanced and number of web pages
             * that can be visited from the page
             */
            std::cout << htmlpage << " is " <<
                (htmlParser.isBalanced(htmlpage) ? "" : "not ") <<
                "balanced." << "\n";
            std::cout << htmlpage << " can visit " << 
                htmlParser.pageVisitAmount(htmlpage) << " pages.\n";
        }
    }
}

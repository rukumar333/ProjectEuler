#include <iostream>
#include <string>

std::string numToWord(std::string num);
std::string threeDigitsToWord(std::string num);
std::string singleDigit[] = {"", "One", "Two", "Three", "Four" , "Five", "Six", "Seven", "Eight", "Nine"};
std::string doubleDigitTen[] = {"Ten", "Eleven", "Twelve", "Thirteen" , "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
std::string doubleDigit[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
std::string threeBunches[] = {"Thousand", "Million", "Billion", "Trillion"};

int main(){
    int testCases = 0;
    std::string temp = "";
    std::getline(std::cin, temp);
    testCases = std::stoi(temp);
    for(int i = 0; i < testCases; ++ i){
	std::getline(std::cin, temp);
	std::cout << numToWord(temp) << std::endl;
    }
    return 1;
}

std::string numToWord(std::string num){
    std::string result = "";
    std::string prepend = "";
    std::string bunch = "";
    char count = 0;
    if(num == "0"){
	return "Zero";
    }
    for(int i = num.length(); i > 0; i = i - 3){
	int begin = i - 3;
	if(begin < 0)
	    prepend = threeDigitsToWord(num.substr(0, i));
	else
	    prepend = threeDigitsToWord(num.substr(begin, 3));
	if(count != 0){
	    bunch = threeBunches[count - 1];
	    if(prepend != "")
		result = prepend + " " + bunch + " " + result;
	}
	else
	    result = prepend;
	++ count;
    }
    return result;
}

std::string threeDigitsToWord(std::string num){
    std::string ending = "";
    if(num.length() == 1)
	return singleDigit[num[0] - '0'];
    if(num.length() >= 2){       
	if(num[num.length() - 2] == '1')
	    ending = doubleDigitTen[num[num.length() - 1] - '0'];
	else{
	    std::string first = doubleDigit[num[num.length() - 2] - '0'];
	    std::string second = singleDigit[num[num.length() - 1] - '0'];
	    if(first == "" || second == "")
		ending = first + second;
	    else
		ending = first + " " + second;
	}
    }
    if(num.length() == 2)
	return ending;
    else
	if(num[0] == '0')
	    return ending;
	else{
	    if(ending != "")
		return singleDigit[num[0] - '0'] + " Hundred " + ending;   
	    else
		return singleDigit[num[0] - '0'] + " Hundred";
	}
    return "";
}

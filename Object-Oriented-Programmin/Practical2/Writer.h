#pragma once
#include <string>
using namespace std;

class Writer
{
private:
	string name;
	string expertize;
public:
	Writer(const string _name, const string _expertize);
	
	string getName()
	{
		return name;
	}
	string getExpertize()
	{
		return expertize;
	}
	~Writer();

};
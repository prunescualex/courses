#pragma once
#include<string>
using namespace std;

class Idea {
private:
	string description, status, creator;
	int act;
public:
	Idea( string _description, const string _status , const string _creator, const int _act);

	inline string getDescription()
	{
		return description;
	}
	inline string getStat()
	{
		return status;
	}
	inline string getCreator()
	{
		return creator;
	}
	inline int getAct()
	{
		return act;
	}
	inline void setStatus(string _status)
	{
		status = _status;
	}
	inline void setCreator(string _creator)
	{
		creator = _creator;
	}
	inline string toList()
	{
		return description + " | " + status + " | " + creator + " | " + to_string(act);
	}

	inline string toString()
	{
		return description + "," + status  + "," + creator + to_string(act);
	}

	inline bool operator == (const Idea &other)
	{
		return description == other.description && status == other.status && creator == other.creator && act == other.act;
	}

	~Idea();
};
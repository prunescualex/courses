#pragma once
#include "Writer.h"
#include "Idea.h"
#include <vector>
#include <string>
#include "Observable.h"

using namespace std;

class Repo : public Observable
{
public:
	Repo(string filename= "ideas.txt");

	void addIdea(Idea act);
	void removeIdea(Idea act);
	void updateIdea(Idea act);
	void saveData(vector<Idea> v1, vector<Idea> v2, vector<Idea> v3);
	
	vector<Idea> getAct1();
	vector<Idea> getAct2();
	vector<Idea> getAct3();

	inline vector<Writer> getWriters()
	{
		return w;
	}
	inline vector<Idea> getIdeas()
	{
		return i;
	}
	~Repo();
	
private:
	
	void readFile(string);
	void sortData();
	void writeData();
	std::vector<Writer> w;
	std::vector<Idea> i;
};
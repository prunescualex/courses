#include "Repo.h"
#include <sstream>
#include <fstream>
#include <algorithm>

Repo::Repo(string filename)
{
	readFile(filename);
}

Repo::~Repo()
{
	writeData();
}

void Repo::addIdea(Idea act)
{
	i.push_back(act);
	sortData();
	notify();
}

void Repo::removeIdea(Idea act)
{
	vector<Idea> newi;
	for (auto it : i)
	{
		if (it.getDescription() != act.getDescription())
			newi.push_back(it);
	}
	i = newi;
	sortData();
	notify();
}

void Repo::updateIdea(Idea act)
{
	for (int it = 0; it < i.size(); it++)
	{
		if (i[it].getDescription() == act.getDescription())
		{
			i[it] = act;
		}
	}
	sortData();
	notify();
}

void Repo::readFile(string filename)
{
	ifstream fin("writer.txt");
	string line;
	while (getline(fin, line))
	{
		stringstream get(line);
		vector <string> all;
		string act;
		while (getline(get, act, ','))
		{
			all.push_back(act);
		}
		w.push_back(Writer(all[0],all[1]));
	}
	fin.close();
	
	fin.open(filename);

	while (getline(fin, line))
	{
		stringstream get(line);
		vector <string> all;
		string act;
		while (getline(get, act, ','))
		{
			all.push_back(act);
		}
		if (all.size() < 3)
		{
			all.push_back("-1");
		}
		i.push_back(Idea(all[0], all[1],all[2], stoi(all[3])));
	}
	sortData();
}
void Repo::writeData()
{
	ofstream fout("plots.txt");
	for (auto it : i)
	{
		fout << it.toString() << "\n";
	}
}

void Repo::saveData(vector<Idea> v1, vector<Idea> v2, vector<Idea> v3)
{
	ofstream fout("plots.txt");
	fout << "Act 1 \n";
	for (auto it : v1)
	{
		fout << it.toString() << "\n";
	}
	fout << "Act 2 \n";
	for (auto it : v2)
	{
		fout << it.toString() << "\n";
	}
	for (auto it : v3)
	{
		fout << it.toString() << "\n";
	}

}

void Repo::sortData()
{
	sort(i.begin(), i.end(), [](Idea &a, Idea &b) {return a.getAct() < b.getAct() || (a.getAct() == b.getAct() && a.getAct() < b.getAct());
	});
}

vector<Idea> Repo::getAct1()
{
	vector<Idea> act1;
	for (auto it : i)
	{
		if (it.getAct() == 1 && it.getStat()=="accepted")
		{
			act1.push_back(it);
		}
	}
	return act1;
}
vector<Idea> Repo::getAct2()
{
	vector<Idea> act2;
	for (auto it : i)
	{
		if (it.getAct() == 2 && it.getStat() == "accepted")
		{
			act2.push_back(it);
		}
	}
	return act2;
}
vector<Idea> Repo::getAct3()
{
	vector<Idea> act3;
	for (auto it : i)
	{
		if (it.getAct() == 3 && it.getStat() == "accepted")
		{
			act3.push_back(it);
		}
	}
	return act3;
}
/*
void Repo::sortData()
{

	sort(i.begin(), i.end(), []( Idea &a, Idea &b) {return a.getCreator() < b.getCreator() || (a.getCreator() == b.getCreator() && a.getCreator() < b.getCreator());
	});
}*/
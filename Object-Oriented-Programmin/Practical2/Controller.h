#pragma once
#include "Repo.h"
#include "Exception.h"

class Controller
{
public:
	Controller(Repo *_r);
	~Controller();
	Repo *r;
	//function that adds idea to repository
	//input - idea to be added
	//output - the new list containg the idea if all the requirements are met
	//		 - exception if there are any problems
	inline void addIdea(Idea act)
	{
		r->addIdea(act);
	}
	//function that removes idea from repository
	//input - idea to be removed
	//output - the new list without the idea given if all requirements are met
	//       - exception if there are any problems
	inline void removeIdea(Idea act)
	{
		r->removeIdea(act);
	}
	/*
	inline Writer getWriter(string exp)
	{
		for (auto it : r->getWriters())
		{
			if (it.getExpertize() == exp)
				return it;
		}
	}*/
	/*
	void startIdea(Writer w, Idea i)
	{
		i.setStatus("proposed");
		i.setCreator(w.getName());
		update(i);
	}*/


	//Function to change given idea status from proposed to accepted
	//input - idea to be accepted
	//output - changed status if the writer is senior / idea is proposed
	//       - exception if there are any problems
	
	void acceptIdea(Writer w,Idea i)
	{
		if (i.getStat() != "proposed")
		{
			throw Exception("Idea already accepted ");
		}
		if (w.getExpertize() != "senior")
		{
			throw Exception("You must be senior writer to accept ideas");
		}
		i.setStatus("accepted");
		update(i);
	}

	void getActs()
	{
		vector<Idea> v1, v2, v3;
		v1 = r->getAct1();
		v2 = r->getAct2();
		v3 = r->getAct3();
		r->saveData(v1,v2,v3);
	}


	void update(Idea act)
	{
		r->updateIdea(act);
	}

	inline vector<Idea> getIdeas()
	{
		return r->getIdeas();
	}
};
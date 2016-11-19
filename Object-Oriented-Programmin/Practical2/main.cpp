#include "practical2.h"
#include <QtWidgets/QApplication>
#include "Controller.h"
#include "Repo.h"
#include "Exception.h"
#include <iostream>
#include <qmessagebox.h>
#include <qstring.h>

int main(int argc, char *argv[])
{
	QApplication a(argc, argv);
	Repo *r = new Repo();
	Controller *c = new Controller(r);
	
	vector<Practical2 *> windows;
	
	for (auto it : r->getWriters())
	{
		
		Practical2 *w = new Practical2(c, it);
		w->show();
		r->attach((Observer *)w);
		windows.push_back(w);
	}
	
	int ret = a.exec();


	return ret;
}

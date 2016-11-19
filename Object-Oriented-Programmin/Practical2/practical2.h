#ifndef PRACTICAL2_H
#define PRACTICAL2_H

#include <QtWidgets/QMainWindow>
#include "ui_practical2.h"
#include "Controller.h"
#include "Writer.h"

class Practical2 : public QMainWindow,public Observer
{
	Q_OBJECT

public:
	Practical2(Controller *_c,Writer _w,QWidget *parent = 0);
	~Practical2();
	void update()
	{
		populateList();
	}

public slots:
	void addIdea();
	void removeIdea();
	void acceptIdea();
	void savePlot();

private:
	Ui::Practical2Class ui;
	int getSelected();
	void populateList();
	void connectSignalsAndSlots();
	Controller *c;
	Writer w;
};

#endif // PRACTICAL2_H

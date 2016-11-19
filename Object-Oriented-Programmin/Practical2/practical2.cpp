#include "practical2.h"
#include "Exception.h"
#include <qmessagebox.h>
#include <qobject.h>
#include <qwidget.h>
#include <qlistwidget.h>



Practical2::Practical2(Controller *_c , Writer _w,QWidget *parent)
	: c(_c),w(_w),QMainWindow(parent)
{
	ui.setupUi(this);
	QWidget::setWindowTitle(QString::fromStdString(w.getName()));
	connectSignalsAndSlots();
	populateList();
}

Practical2::~Practical2()
{

}

void Practical2::populateList()
{
	ui.listIdeas->clear();
	for (auto it : c->getIdeas())
	{
		QString s = QString::fromStdString(it.toList());
		ui.listIdeas->addItem(new QListWidgetItem(s));
	}
}
void Practical2::connectSignalsAndSlots() {
	QObject::connect(ui.addButton, SIGNAL(clicked()), this, SLOT(addIdea()));
	QObject::connect(ui.acceptButton, SIGNAL(clicked()), this, SLOT(acceptIdea()));
	QObject::connect(ui.removeButton, SIGNAL(clicked()), this, SLOT(removeIdea()));
	QObject::connect(ui.saveButton, SIGNAL(clicked()), this, SLOT(savePlot()));
}

void Practical2::savePlot()
{
	c->getActs();
}

/*
	Function that adds and idea in the current list of ideas
	Input - Idea to be added defined by description and act , the status will be set to processed and cretator to the initializer of the idea
	Output - The new list of ideas If it met all the requirements
		   - Exception if description too short , already in the list , or not a valid act was given
*/

void Practical2::addIdea()
{
	string desc = ui.lineDescription->text().toStdString();
	int act = ui.lineAct->text().toInt();
	if (desc.size() < 3)
	{
		QMessageBox::critical(this, "Add Idea", "Please give a better description !", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	if (act != 1)
	{
		if (act != 2)
		{
			if (act != 3)
			{
				QMessageBox::critical(this, "Add Idea", "Please choose act 1 , 2 or 3!", QMessageBox::Ok, QMessageBox::Ok);
				return;
			}
		}
	}
	for (auto it : c->getIdeas())
	{
		if (it.getDescription() == desc)
		{
			QMessageBox::critical(this, "Add Idea", "Please choose different name!", QMessageBox::Ok, QMessageBox::Ok);
			return;
		}
	}
	Idea i(desc, "proposed", w.getName(), act);
	c->addIdea(i);
}

/*
	Function that enables senior writers to accept proposed ideas
	Input - selected Ideas from current list
	Output - Status changed to accepted if the requirements are met
		   - Exceptions if the writer is not senior / item is not selected / idea already accepted
*/

void Practical2::acceptIdea()
{
	int ind  = getSelected();
	if (ind == -1)
	{
		QMessageBox::critical(this, "Accept Idea", "Please select an item from the list in order to remove it!", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	if (w.getExpertize() != "senior")
	{
		QMessageBox::critical(this, "Accept Idea", "Only seniors can accept ideas!", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	Idea i = c->getIdeas()[ind];
	c->acceptIdea(w,i);
}

/*
	Function that removes a selected idea from the current list
	Input - The idea to be removed 
	Output- The new list containing no longer the idea given
		  - Exception if no element was selected or the writer is not a senior
*/

void Practical2::removeIdea()
{
	int ind = getSelected();
	if (ind == -1)
	{
		QMessageBox::critical(this, "Remove Idea", "Please select an item from the list in order to remove it!", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	if (w.getExpertize() != "senior")
	{
		QMessageBox::critical(this, "Remove Idea", "Only seniors can remove ideas!", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	if (c->getIdeas()[ind].getStat() == "accepted")
	{
		QMessageBox::critical(this, "Remove Idea", "Only proposed ideas can be removed!", QMessageBox::Ok, QMessageBox::Ok);
		return;
	}
	c->removeIdea(c->getIdeas()[ind]);
}

int Practical2::getSelected() {
	auto v = ui.listIdeas->selectedItems();
	if (v.size() == 0)
		return -1;
	return ui.listIdeas->row(v[0]);
}

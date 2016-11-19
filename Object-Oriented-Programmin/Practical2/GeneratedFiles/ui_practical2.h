/********************************************************************************
** Form generated from reading UI file 'practical2.ui'
**
** Created by: Qt User Interface Compiler version 5.6.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PRACTICAL2_H
#define UI_PRACTICAL2_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Practical2Class
{
public:
    QWidget *centralWidget;
    QListWidget *listIdeas;
    QLineEdit *lineDescription;
    QLineEdit *lineAct;
    QPushButton *addButton;
    QPushButton *acceptButton;
    QPushButton *removeButton;
    QPushButton *saveButton;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *Practical2Class)
    {
        if (Practical2Class->objectName().isEmpty())
            Practical2Class->setObjectName(QStringLiteral("Practical2Class"));
        Practical2Class->resize(600, 400);
        centralWidget = new QWidget(Practical2Class);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        listIdeas = new QListWidget(centralWidget);
        listIdeas->setObjectName(QStringLiteral("listIdeas"));
        listIdeas->setGeometry(QRect(20, 20, 301, 211));
        lineDescription = new QLineEdit(centralWidget);
        lineDescription->setObjectName(QStringLiteral("lineDescription"));
        lineDescription->setGeometry(QRect(410, 40, 171, 22));
        lineAct = new QLineEdit(centralWidget);
        lineAct->setObjectName(QStringLiteral("lineAct"));
        lineAct->setGeometry(QRect(410, 90, 171, 22));
        addButton = new QPushButton(centralWidget);
        addButton->setObjectName(QStringLiteral("addButton"));
        addButton->setGeometry(QRect(350, 150, 93, 28));
        acceptButton = new QPushButton(centralWidget);
        acceptButton->setObjectName(QStringLiteral("acceptButton"));
        acceptButton->setGeometry(QRect(30, 250, 93, 28));
        removeButton = new QPushButton(centralWidget);
        removeButton->setObjectName(QStringLiteral("removeButton"));
        removeButton->setGeometry(QRect(170, 250, 93, 28));
        saveButton = new QPushButton(centralWidget);
        saveButton->setObjectName(QStringLiteral("saveButton"));
        saveButton->setGeometry(QRect(300, 250, 93, 28));
        label = new QLabel(centralWidget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(330, 40, 71, 16));
        label_2 = new QLabel(centralWidget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(340, 90, 55, 16));
        label_3 = new QLabel(centralWidget);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(20, 0, 71, 16));
        Practical2Class->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(Practical2Class);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 600, 26));
        Practical2Class->setMenuBar(menuBar);
        mainToolBar = new QToolBar(Practical2Class);
        mainToolBar->setObjectName(QStringLiteral("mainToolBar"));
        Practical2Class->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(Practical2Class);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        Practical2Class->setStatusBar(statusBar);

        retranslateUi(Practical2Class);

        QMetaObject::connectSlotsByName(Practical2Class);
    } // setupUi

    void retranslateUi(QMainWindow *Practical2Class)
    {
        Practical2Class->setWindowTitle(QApplication::translate("Practical2Class", "Practical2", 0));
        addButton->setText(QApplication::translate("Practical2Class", "Add", 0));
        acceptButton->setText(QApplication::translate("Practical2Class", "Accept", 0));
        removeButton->setText(QApplication::translate("Practical2Class", "Remove", 0));
        saveButton->setText(QApplication::translate("Practical2Class", "Save Plot", 0));
        label->setText(QApplication::translate("Practical2Class", "Description", 0));
        label_2->setText(QApplication::translate("Practical2Class", "Act", 0));
        label_3->setText(QApplication::translate("Practical2Class", "Description", 0));
    } // retranslateUi

};

namespace Ui {
    class Practical2Class: public Ui_Practical2Class {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PRACTICAL2_H

#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_UseUpx=y
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****
#cs ----------------------------------------------------------------------------

	AutoIt Version: 3.3.14.2
	Author:         myName

	Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------
; Script Start - Add your code below here
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Constants.au3>

WinActivate("Visa Test System")
WinMenuSelectItem("Visa Test System", "", "&View", "&Detail Log...")
WinWaitActive("LogViewer")
WinMenuSelectItem("LogViewer", "", "&File", "&Delete...")
If WinExists("LogViewer", "Error Setting Date Range") Then
	ControlClick("LogViewer", "", "Button1")
EndIf
WinWaitActive("Delete Log")
ControlClick("Delete Log", "", "[CLASS:Button; INSTANCE:5]")
ControlClick("Delete Log", "", "[CLASS:Button; INSTANCE:2]")
WinWaitActive("LogViewer")
ControlClick("LogViewer", "", "[CLASS:Button; INSTANCE:1]")
Sleep(1000)
ControlClick("LogViewer", "", "[CLASS:Button; INSTANCE:1]")
WinMenuSelectItem("LogViewer", "", "&File", "E&xit")
WinMenuSelectItem("LogViewer", "", "&File", "&E&xit")

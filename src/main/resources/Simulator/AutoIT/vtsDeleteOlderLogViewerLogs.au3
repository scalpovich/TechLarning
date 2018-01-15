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
   WinWaitActive("LogViewer (1)")
   WinMenuSelectItem("LogViewer (1)", "", "&File", "&Delete...")
   WinWaitActive("Delete Log")
   ControlClick("Delete Log", "", "[CLASS:Button; INSTANCE:5]")
   ControlClick("Delete Log", "", "[CLASS:Button; INSTANCE:2]")
   WinWaitActive("LogViewer")
   ControlClick("LogViewer", "", "[CLASS:Button; INSTANCE:1]")
   Sleep(1000)
   ControlClick("LogViewer", "", "[CLASS:Button; INSTANCE:1]")
   WinMenuSelectItem("LogViewer (1)", "", "&File", "E&xit")

   WinMenuSelectItem("LogViewer (1)", "", "&File", "&E&xit")
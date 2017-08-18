#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Date.au3>
#include <File.au3>
#include <MsgBoxConstants.au3>

Local $sDate = _NowCalcDate();
Local $sTodaysDate =  StringReplace($sDate, "/", "")
; Generate a unique filename in @TempDir
Local $sTempFile_1 = @TempDir() &"\" & $sTodaysDate &"_IssuingTests_Simulator";
DirCreate ($sTempFile_1);
Local $sFileName;
   sleep(2000)
	WinActivate("Save As", "&Save")
	sleep(500)

   $sFileName = ControlGetText("Save As","","[CLASS:ComboBox; INSTANCE:1]");

   $filedir =$sTempFile_1 &"\"& $sFileName; ;Directory in Temp Folder

	sleep(1000)
	ControlSetText("Save As","","[CLASS:ComboBox; INSTANCE:1]","") ; erase the file name to make room for the $dest string
	sleep(1000)
    ControlSetText("Save As","","[CLASS:ComboBox; INSTANCE:1]", $filedir) ; set the Edit1 text to the $dest and hit the button to swithc directories.
    sleep(1000)
    ControlClick("Save As","","[CLASS:Button; INSTANCE:1]")
	sleep(2000)
    ControlClick("Generate Text File","","[NAME:Cmd_OK]")

	FileWrite($sTempFile_1 &"\AuthFileName.txt", $sFileName)
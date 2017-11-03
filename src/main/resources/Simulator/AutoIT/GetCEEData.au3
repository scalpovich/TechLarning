#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
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

	WinActivate("CEE", "OK")
	Local $sText = ControlGetText ("CEE", "", "[CLASS:Static; INSTANCE:2]")

   $filedir =$sTempFile_1 ;Directory in Temp Folder
   $filename = "CEEData.txt" ;Ini file name.

   $filePath = StringReplace($filedir, "\Simulator\AutoIT", "") & "\" & $filename

    ; Delete the temporary file.
    FileDelete($filePath)


	FileWrite($filePath, $sText)
	ControlClick("CEE", "", "[CLASS:Button; INSTANCE:1]")
@echo off
cls
:menu
cls
date /t
echo Computador: %computername%        Usuario: %username%
                  
echo            MENU TAREFAS
echo  ==================================
echo * 1. Build da Aplicacao           * 
echo * 2. Start na Aplicacao           *
echo * 3. Sair do terminal             * 
echo  ==================================

set /p opcao= Escolha uma opcao: 
echo ------------------------------
if %opcao% equ 1 goto opcao1
if %opcao% equ 2 goto opcao2
if %opcao% equ 3 goto opcao3

:opcao1
cls
mvnw.cmd clean install spring-boot:run
echo ==================================
echo * Efetuando o Build do Projeto   *
echo * e start na aplicacao           *
echo ==================================
pause
goto menu

:opcao2
cls
java -jar target\robo-CA-2023.jar
echo ==================================
echo *      Start da aplicacao        *
echo ==================================
pause
goto menu

:opcao3
cls
exit

:opcao6
echo ==============================================
echo * Opcao Invalida! Escolha outra opcao do menu *
echo ==============================================
pause
goto menu
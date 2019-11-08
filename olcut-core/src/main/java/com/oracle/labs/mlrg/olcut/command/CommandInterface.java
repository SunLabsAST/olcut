/*
 * Copyright 1999-2002 Carnegie Mellon University.  
 * Portions Copyright 2002 Sun Microsystems, Inc.  
 * Portions Copyright 2002 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 * 
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL 
 * WARRANTIES.
 *
 */
package com.oracle.labs.mlrg.olcut.command;

/**
 * An interface implemented by command functions typically
 * added to a command interpreter
 *
 * @see CommandInterpreter
 */
public interface CommandInterface {

    /**
     * Execute the given command.
     *  
     * @param ci	the command interpreter that invoked this command.
     * @param args	command line arguments (just like main).
     * @return		a command result
     * @throws Exception Can throw an exception.
     */
    public String execute(CommandInterpreter ci, String[] args) throws Exception;

    /**
     * Returns a one line description of the command
     *
     * @return a one-liner help message
     */
    public String getHelp();
}

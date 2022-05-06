package com.udemy.basic.dp.behavioral;

import org.junit.Before;
import org.junit.Test;

public class IBehaviroalTest {

	IBehaviroal ibh = null;

	@Before
	public void init() {
		ibh = new BehavioralImpl();
	}

	/** Chain of Responsibility Design Pattern **/

	/* Chain of Responsibility Design Pattern Example **/
	@Test
	public void chainOfResponsibilityExmplTest() {
		ibh.chainOfResponsibilityExmpl();
	}

	/* Chain of Responsibility Design Pattern Challenge **/
	@Test
	public void chainOfResponsibilityChallengeTest() {
		ibh.chainOfResponsibilityChallenge();
	}

	/** Command design pattern */

	/* Command design pattern examples */
	@Test
	public void commandPatterExampleTest() {
		ibh.commandPatterExample();
	}

	/* Command design pattern Challenge */
	@Test
	public void commandPatterChallengeTest() {
		ibh.commandPatterChallenge();
	}

	/** Interpreter design pattern */

	/* Interpreter design pattern Example */
	@Test
	public void interpreterPatternExamplTest() {
		ibh.interpreterPatternExampl();
	}

	/* Interpreter design pattern Challenge */
	@Test
	public void interpreterPatternChallengeTest() {
		ibh.interpreterPatternChallenge();
	}

}

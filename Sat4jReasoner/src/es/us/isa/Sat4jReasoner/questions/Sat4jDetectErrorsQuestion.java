/*
	This file is part of FaMaTS.

    FaMaTS is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FaMaTS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with FaMaTS.  If not, see <http://www.gnu.org/licenses/>.

 */
package es.us.isa.Sat4jReasoner.questions;

import java.util.Collection;

import es.us.isa.FAMA.Benchmarking.PerformanceResult;

import es.us.isa.FAMA.Exceptions.FAMAParameterException;
import es.us.isa.FAMA.Reasoner.Reasoner;
import es.us.isa.FAMA.Reasoner.questions.DetectErrorsQuestion;
import es.us.isa.FAMA.Reasoner.questions.ValidQuestion;
import es.us.isa.FAMA.Reasoner.questions.defaultImpl.DefaultDetectErrorsQuestion;
import es.us.isa.FAMA.errors.Error;
import es.us.isa.FAMA.errors.Observation;
import es.us.isa.Sat4jReasoner.Sat4jQuestion;
import es.us.isa.Sat4jReasoner.Sat4jResult;

public class Sat4jDetectErrorsQuestion extends Sat4jQuestion implements
		DetectErrorsQuestion {

	private DefDetectErrorsQuestion dtq;
	
	public Sat4jDetectErrorsQuestion() {
		super();
		dtq = new DefDetectErrorsQuestion();
	}

	
	public Collection<Error> getErrors() {
		return dtq.getErrors();
	}

	
	public void setObservations(Collection<Observation> observations) {
		dtq.setObservations(observations);
		
	}
	
	
	public PerformanceResult answer(Reasoner r) {
		if(r==null){
			throw new FAMAParameterException("Reasoner :Not specified");
		}
		return dtq.answer(r);
	}
	
	public String toString(){
		return this.dtq.toString();
	}
	
	class DefDetectErrorsQuestion extends DefaultDetectErrorsQuestion{

		

		
		public PerformanceResult performanceResultFactory() {
			return new Sat4jResult();
		}

	

		
		public ValidQuestion validQuestionFactory() {
			return new Sat4jValidQuestion();
		}

		
		public Class<? extends Reasoner> getReasonerClass() {
			return null;
		}

		
		
	}

}

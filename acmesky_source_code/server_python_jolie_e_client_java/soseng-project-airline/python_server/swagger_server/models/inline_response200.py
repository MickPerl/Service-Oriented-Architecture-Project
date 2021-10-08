# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server.models.l_mflight_flight import LMflightFlight  # noqa: F401,E501
from swagger_server import util


class InlineResponse200(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, flights: List[LMflightFlight]=None, companyname: str=None):  # noqa: E501
        """InlineResponse200 - a model defined in Swagger

        :param flights: The flights of this InlineResponse200.  # noqa: E501
        :type flights: List[LMflightFlight]
        :param companyname: The companyname of this InlineResponse200.  # noqa: E501
        :type companyname: str
        """
        self.swagger_types = {
            'flights': List[LMflightFlight],
            'companyname': str
        }

        self.attribute_map = {
            'flights': 'flights',
            'companyname': 'companyname'
        }
        self._flights = flights
        self._companyname = companyname

    @classmethod
    def from_dict(cls, dikt) -> 'InlineResponse200':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The inline_response_200 of this InlineResponse200.  # noqa: E501
        :rtype: InlineResponse200
        """
        return util.deserialize_model(dikt, cls)

    @property
    def flights(self) -> List[LMflightFlight]:
        """Gets the flights of this InlineResponse200.


        :return: The flights of this InlineResponse200.
        :rtype: List[LMflightFlight]
        """
        return self._flights

    @flights.setter
    def flights(self, flights: List[LMflightFlight]):
        """Sets the flights of this InlineResponse200.


        :param flights: The flights of this InlineResponse200.
        :type flights: List[LMflightFlight]
        """

        self._flights = flights

    @property
    def companyname(self) -> str:
        """Gets the companyname of this InlineResponse200.


        :return: The companyname of this InlineResponse200.
        :rtype: str
        """
        return self._companyname

    @companyname.setter
    def companyname(self, companyname: str):
        """Sets the companyname of this InlineResponse200.


        :param companyname: The companyname of this InlineResponse200.
        :type companyname: str
        """

        self._companyname = companyname